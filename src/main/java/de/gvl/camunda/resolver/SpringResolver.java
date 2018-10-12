package de.gvl.camunda.resolver;

import static org.camunda.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.camunda.bpm.engine.impl.scripting.engine.Resolver;
import org.springframework.context.ApplicationContext;

public class SpringResolver implements Resolver {

  private final ApplicationContext applicationContext;

  private final Set<String> beannames;

  public SpringResolver(final ApplicationContext applicationContext) {
    ensureNotNull("applicationContext", applicationContext);
    this.applicationContext = applicationContext;
    this.beannames = new HashSet<>(Arrays.asList(applicationContext.getBeanDefinitionNames()));
  }

  @Override
  public boolean containsKey(final Object key) {
    return beannames.contains(key);
  }

  @Override
  public Object get(final Object key) {
    return applicationContext.getBean((String) key);
  }

  @Override
  public Set<String> keySet() {
    return beannames;
  }
}

