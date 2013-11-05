/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
