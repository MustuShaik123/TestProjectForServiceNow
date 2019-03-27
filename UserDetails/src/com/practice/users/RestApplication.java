/**
 * (c) Copyright 2002-2017 ADP (Automatic Data Processing), Inc.
 *
 * All rights reserved. Information in this publication is subject to change
 * without notice. No part of this publication may be reproduced in any form
 * without prior written permission of ADP Inc. ADP is a registered trademark
 * of ADP Inc.
 *
 * Other products mentioned in this publication may be registered trademarks,
 * trademarks, or service marks of their respective manufacturers, companies,
 * or organizations.
 */
package com.practice.users;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.practice.users.impl.UserDetailsApiImpl;

@ApplicationPath("rest")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		/* here we need to include all of the resource classes that are under /rest */
		HashSet<Class<?>> classes = new HashSet<>();	

		classes.add(UserDetailsApiImpl.class);
		
		return classes;
	}

}
