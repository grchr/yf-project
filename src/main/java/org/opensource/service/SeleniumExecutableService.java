package org.opensource.service;

import org.opensource.model.AbstractCompanyInformation;

import java.util.concurrent.CompletableFuture;

public interface SeleniumExecutableService<T extends AbstractCompanyInformation> {

  public T execute(String ticker);

  public CompletableFuture<T> executeAsync(String ticker);
}
