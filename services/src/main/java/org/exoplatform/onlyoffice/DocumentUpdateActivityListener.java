package org.exoplatform.onlyoffice;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.jcr.Node;
import javax.jcr.Property;

import org.apache.commons.chain.Context;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.ext.action.InvocationContext;
import org.exoplatform.services.listener.Event;
import org.exoplatform.wcm.ext.component.activity.listener.FileUpdateActivityListener;

/**
 * The listener interface for receiving documentUpdateActivity events.
 * The class that is interested in processing a documentUpdateActivity
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's addDocumentUpdateActivityListener method. When
 * the documentUpdateActivity event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class DocumentUpdateActivityListener extends FileUpdateActivityListener {

  /** The Constant EVENT_DELAY in min. */
  protected static final long     EVENT_DELAY = 10;
  
  /** The editor service. */
  private OnlyofficeEditorService editorService;

  /**
   * Instantiates a new document update activity listener.
   */
  public DocumentUpdateActivityListener() {
    editorService = (OnlyofficeEditorService) ExoContainerContext.getCurrentContainer()
                                                                 .getComponentInstanceOfType(OnlyofficeEditorService.class);
  }

  /**
   * Event handler.
   *
   * @param event the event
   * @throws Exception the exception
   */
  @Override
  public void onEvent(Event<Context, String> event) throws Exception {
    Context context = event.getSource();
    Property currentProperty = (Property) context.get(InvocationContext.CURRENT_ITEM);
    Node currentNode = currentProperty.getParent().getParent();
    String lastModifier = currentNode.getProperty("exo:lastModifier").getString();
    String workspace = currentNode.getSession().getWorkspace().getName();
    String path = currentNode.getPath();
    Config config = editorService.getEditor(lastModifier, workspace, path);
    if (config != null && config.getSameModifier() != null && config.getPreviousModified() != null) {
      boolean sameModifier = config.getSameModifier();
      Calendar previousModified = config.getPreviousModified();
      long difference = Calendar.getInstance().getTimeInMillis() - previousModified.getTimeInMillis();
      if (!sameModifier || TimeUnit.MILLISECONDS.toMinutes(difference) > EVENT_DELAY) {
        super.onEvent(event);
      }
      // Manually updated node
    } else {
      super.onEvent(event);
    }
  }
}
