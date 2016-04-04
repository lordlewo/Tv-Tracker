/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.webtown.liferay.tvtracker;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author czeni
 */
public class SeasonPremierDateException extends PortalException {

	public SeasonPremierDateException() {
		super();
	}

	public SeasonPremierDateException(String msg) {
		super(msg);
	}

	public SeasonPremierDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SeasonPremierDateException(Throwable cause) {
		super(cause);
	}

}