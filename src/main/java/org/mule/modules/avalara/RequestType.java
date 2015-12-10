/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara;

/**
 * @author Damian Pelaez
 * @since Nov 4, 2013
 */
public interface RequestType {

	/**
     * @return the simple name of the associated class for this entity type
     */
	public String getSimpleName();
	
	/**
     * @return the resource name of the associated class for this entity type
     */
	public String getResourceName();
	
	/**
     * @return new instance of the associated class for this entity type
     */
	public <T> T newInstance();
	
	/**
     * @return the associated class for this entity type
     */
	public <T> Class<T> getType();
	
}
