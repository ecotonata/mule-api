/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.api.artifact.ast;

import org.mule.runtime.api.component.location.BaseLocation;
import org.mule.runtime.api.dsl.ConfigurationPropertyResolutionException;
import org.mule.runtime.api.dsl.ResolvedValue;
import org.mule.runtime.api.util.Either;

public class SimpleParameterValueAst extends ParameterValueAst {

  private String rawValue;
  private Either<ConfigurationPropertyResolutionException, ResolvedValue> resolvedValueResult;

  public String getRawValue() {
    return rawValue;
  }

  public Either<ConfigurationPropertyResolutionException, ResolvedValue> getResolvedValueResult() {
    return resolvedValueResult;
  }

  public void setResolvedValueResult(Either<ConfigurationPropertyResolutionException, ResolvedValue> resolvedValueResult) {
    this.resolvedValueResult = resolvedValueResult;
  }

  public static SimpleParameterValueAstBuilder builder() {
    return new SimpleParameterValueAstBuilder();
  }

  public static final class SimpleParameterValueAstBuilder {

    private BaseLocation location;
    private String rawValue;
    private SourceCodeLocation sourceCodeLocation;

    private SimpleParameterValueAstBuilder() {}

    public SimpleParameterValueAstBuilder withLocation(BaseLocation location) {
      this.location = location;
      return this;
    }

    public SimpleParameterValueAstBuilder withRawValue(String rawValue) {
      this.rawValue = rawValue;
      return this;
    }

    public SimpleParameterValueAstBuilder withSourceCodeLocation(SourceCodeLocation sourceCodeLocation) {
      this.sourceCodeLocation = sourceCodeLocation;
      return this;
    }

    public SimpleParameterValueAst build() {
      SimpleParameterValueAst parameterValue = new SimpleParameterValueAst();
      parameterValue.rawValue = this.rawValue;
      parameterValue.location = this.location;
      parameterValue.sourceCodeLocation = this.sourceCodeLocation;
      return parameterValue;
    }
  }

}
