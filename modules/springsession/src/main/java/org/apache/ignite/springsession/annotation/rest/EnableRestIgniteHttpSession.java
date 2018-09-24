/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.springsession.annotation.rest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.ignite.springsession.annotation.IgniteRestSessionRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.session.MapSession;

/**
 * Annotation to enable Ignite-REST session clustering.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(IgniteRestHttpSessionConfiguration.class)
@Configuration
public @interface EnableRestIgniteHttpSession {
    /** Max inactive time interval for session to expire.
     *
     * @return Max inactive interval in seconds.
     */
    int maxInactiveIntervalInSeconds() default MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;

    /** Session cache name.
     *
     * @return Session cache name.
     */
    String sessionCacheName() default IgniteRestSessionRepository.DFLT_SESSION_STORAGE_NAME;

    /** URL.
     *
     * @return Ignite URL.
     */
    String url() default IgniteRestSessionRepository.DFLT_URL;
}
