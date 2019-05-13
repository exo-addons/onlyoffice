
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
package org.exoplatform.onlyoffice;

/**
 * Created by The eXo Platform SAS.
 *
 * @author <a href="mailto:pnedonosko@exoplatform.com">Peter Nedonosko</a>
 * @version $Id: OnlyofficeEditorException.java 00000 Jan 31, 2016 pnedonosko $
 */
public class OnlyofficeEditorException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -8981933520830552416L;

  /**
   * Instantiates a new onlyoffice editor exception.
   *
   * @param message the message
   */
  public OnlyofficeEditorException(String message) {
    super(message);
  }

  /**
   * Instantiates a new onlyoffice editor exception.
   *
   * @param cause the cause
   */
  public OnlyofficeEditorException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new onlyoffice editor exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public OnlyofficeEditorException(String message, Throwable cause) {
    super(message, cause);
  }

}
