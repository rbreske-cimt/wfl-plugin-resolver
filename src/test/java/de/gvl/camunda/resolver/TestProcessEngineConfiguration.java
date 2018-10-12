package de.gvl.camunda.resolver;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;

/**
 * Spring Process Engine Configuration for testing purposes.
 * 
 * @author rbreske
 *
 */
public class TestProcessEngineConfiguration extends SpringProcessEngineConfiguration {
	
	public void setProcessEnginePlugin(ProcessEnginePlugin plugin) {
		List<ProcessEnginePlugin> plugins = getProcessEnginePlugins();
		if (plugins == null) {
			plugins = new ArrayList<ProcessEnginePlugin>();
			setProcessEnginePlugins(plugins);
		}
		plugins.add(plugin);
	}
	
}
