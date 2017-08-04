/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.tinet.tsso.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * 用于给实现了cas的应用产生shiro的subject的实现类
 * 
 * @author 李政
 * @date 2017年8月3日
 */
public class CasSubjectFactory extends DefaultWebSubjectFactory {

	@Override
	public Subject createSubject(SubjectContext context) {

		// the authenticated flag is only set by the SecurityManager after a
		// successful authentication attempt.
		// 译：这个flag只会被SecurityManager在认证成功时候尝试设置
		boolean authenticated = context.isAuthenticated();

		// although the SecurityManager 'sees' the submission as a successful
		// authentication, in reality, the
		// login might have been just a CAS rememberMe login. If so, set the
		// authenticated flag appropriately:
		
		// 译：尽管SecurityManager可以看到认证成功了，但实际上，这次登录有可能只是一个CAS的 rememberMe登录
		//    如果是这样的话，设置合适的flag（其实就是false）
		if (authenticated) {

			AuthenticationToken token = context.getAuthenticationToken();

			if (token != null && token instanceof CasToken) {
				CasToken casToken = (CasToken) token;
				// set the authenticated flag of the context to true only if the
				// CAS subject is not in a remember me mode
				
				// 译：只有在CAS不是rememberMe 模式时候才把flag设置成true
				if (casToken.isRememberMe()) {
					context.setAuthenticated(false);
				}
			}
		}

		return super.createSubject(context);
	}
}
