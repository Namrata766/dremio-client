package com.dell.dremioclient.config;

import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dell.dremioclient.config.ApplicationProperties.DremioProperties;
import com.dell.dremioclient.utils.AdhocFlightClient;

@Configuration
public class AdhocFlightClientConfig {

	private static final BufferAllocator BUFFER_ALLOCATOR = new RootAllocator(Integer.MAX_VALUE);
	
	@Bean
	public AdhocFlightClient createFlightClient(DremioProperties dremProp) throws Exception {

		return AdhocFlightClient.getEncryptedClient(BUFFER_ALLOCATOR,
				dremProp.getHost(), dremProp.getPort(),
				dremProp.getUsername(), dremProp.getPassword(),
				null,
				dremProp.getKeystorepath(), dremProp.getKeystorepassword(),
				false /*disableServerVerification*/,
				null /* clientProperties */,
				null);
	}
}
