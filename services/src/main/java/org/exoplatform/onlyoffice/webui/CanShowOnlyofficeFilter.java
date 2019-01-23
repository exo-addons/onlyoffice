
/*
 * Copyright (C) 2003-2018 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.onlyoffice.webui;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.exoplatform.onlyoffice.OnlyofficeEditorException;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.webui.core.UIContainer;
import org.exoplatform.webui.ext.filter.UIExtensionFilterType;

/**
 * Created by The eXo Platform SAS.
 *
 * @author <a href="mailto:pnedonosko@exoplatform.com">Peter Nedonosko</a>
 * @version $Id: IsNotEditingOnlyofficeFilter.java 00000 Mar 1, 2016 pnedonosko $
 */
@Deprecated
public class CanShowOnlyofficeFilter extends AbstractOnlyofficeFilter {

  /**
   * Instantiates a new can show onlyoffice filter.
   */
  public CanShowOnlyofficeFilter() {
  }

  /**
   * Instantiates a new can show onlyoffice filter.
   *
   * @param forceNotEditing the force not editing
   */
  public CanShowOnlyofficeFilter(boolean forceNotEditing) {
  }

  /**
   * Instantiates a new can show onlyoffice filter.
   *
   * @param messageKey the message key
   */
  public CanShowOnlyofficeFilter(String messageKey) {
    super(messageKey);
  }

  /**
   * Instantiates a new can show onlyoffice filter.
   *
   * @param messageKey the message key
   * @param type the type
   */
  public CanShowOnlyofficeFilter(String messageKey, UIExtensionFilterType type) {
    super(messageKey, type);
  }

  /**
   * {@inheritDoc}
   */
  public UIExtensionFilterType getType() {
    return UIExtensionFilterType.MANDATORY;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean accept(String userId, Node node, UIContainer container) throws RepositoryException, OnlyofficeEditorException {
    OnlyofficeEditorUIService editorsUI = WCMCoreUtils.getService(OnlyofficeEditorUIService.class);
    return editorsUI.canShow(userId, node.getSession().getWorkspace().getName(), node.getPath());
  }
}
