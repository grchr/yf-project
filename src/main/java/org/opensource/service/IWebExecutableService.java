package org.opensource.service;

import org.opensource.model.AbstractCompanyInformation;

import java.util.concurrent.CompletableFuture;

public interface IWebExecutableService<T extends AbstractCompanyInformation> {

  T execute(String ticker);

  CompletableFuture<T> executeAsync(String ticker);

}
