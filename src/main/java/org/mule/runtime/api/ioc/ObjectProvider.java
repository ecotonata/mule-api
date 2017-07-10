/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.ioc;

import org.mule.runtime.api.lifecycle.Initialisable;
import org.mule.runtime.api.meta.AnnotatedObject;

import java.util.Map;
import java.util.Optional;

/**
 * Interface meant to be implemented by components that will provide objects that may be referenced from mule configuration files.
 * <p/>
 * This interface may make use of {@link org.mule.runtime.api.lifecycle.Lifecycle} interfaces.
 * 
 * @since 1.0
 */
public interface ObjectProvider extends AnnotatedObject {

  /**
   * Method to be called to prepare the {@link ObjectProvider}. It is expected that the provider is ready to be used after calling
   * this method.
   * <p/>
   * This method will be invoke before {@link Initialisable#initialise()} if the implementation implements that interface.
   *
   * @param objectProviderConfiguration configuration for the provider.
   */
  void configure(ObjectProviderConfiguration objectProviderConfiguration);

  /**
   * Finds an object by name
   * 
   * @param name the object name
   * @return the object if there's one, empty otherwise.
   */
  Optional<Object> getObject(String name);

  /**
   * Finds an object by type
   * 
   * @param objectType the object type.
   * @return the object if there's one, empty otherwise. In case there are many, then it will fail unless there's a preferred one.
   *         How the preferred one is defined is up to the {@link ObjectProvider} implementation.
   */
  Optional<Object> getObjectByType(Class<?> objectType);

  /**
   * Finds all objects matching the given type
   *
   * @param type the object type class object
   * @param <T> type parameter for the object
   * @return a map where the keys are the object names and the values the objects associated with the key
   */
  <T> Map<String, T> getObjectsByType(Class<T> type);

  /**
   * @param name bean name
   * @return true if the object is a singleton, false if it's not, empty if there's no an object with that name.
   */
  Optional<Boolean> isObjectSingleton(String name);
}