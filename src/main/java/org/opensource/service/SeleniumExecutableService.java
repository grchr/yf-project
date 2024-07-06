package org.opensource.service;

import org.opensource.model.AbstractCompanyInformation;

public interface SeleniumExecutableService<T extends AbstractCompanyInformation> {

  public T execute(String ticker);
}
