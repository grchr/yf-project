package org.opensource.model;

public abstract class AbstractCompanyInformation {

  protected AbstractCompanyInformation() {
  }

  public static abstract class AbstractCompanyInfoBuilder<T extends AbstractCompanyInfoBuilder<T>> {

    // Abstract build method to be implemented by concrete builders
    public abstract AbstractCompanyInformation build();

    public abstract AbstractCompanyInfoBuilder<T> self();
  }

}
