//package com.example.auth.conf;
//
//import io.lettuce.core.ClientOptions;
//import io.lettuce.core.ReadFrom;
//import io.lettuce.core.SocketOptions;
//import io.lettuce.core.cluster.ClusterClientOptions;
//import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
//import io.lettuce.core.cluster.RedisClusterClient;
//import io.lettuce.core.internal.HostAndPort;
//import io.lettuce.core.resource.ClientResources;
//import io.lettuce.core.resource.DefaultClientResources;
//import io.lettuce.core.resource.DnsResolvers;
//import io.lettuce.core.resource.MappingSocketAddressResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.time.Duration;
//import java.util.Arrays;
//
//import static io.lettuce.core.cluster.ClusterClientOptions.DEFAULT_REFRESH_CLUSTER_VIEW;
//import static io.lettuce.core.cluster.ClusterClientOptions.DEFAULT_REFRESH_PERIOD_DURATION;
//
//@Configuration
//public class RedisClusterConf {
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        MappingSocketAddressResolver resolver = MappingSocketAddressResolver.create(DnsResolvers.UNRESOLVED,
//                hostAndPort -> {
//                    HostAndPort andPort = HostAndPort.of("127.0.0.1", hostAndPort.getPort());
//                    return andPort;
//                }
//        );
//        ClientResources clientResources = ClientResources.builder()
//                .socketAddressResolver(resolver)
//                .build();
//
////        RedisClusterClient.create(clientResources, redisUri);
//
////        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
////                .clientResources(clientResources)
////                .build();
//
//        ClusterTopologyRefreshOptions clusterTopologyRefreshOptions = ClusterTopologyRefreshOptions.builder() //
//                .enablePeriodicRefresh() // Breakpoint here and enter to enable refreshing
//                .refreshPeriod(DEFAULT_REFRESH_PERIOD_DURATION) // Breakpoint here and enter to set the refresh interval
//                .closeStaleConnections(true) //
//                .build();
//        ClientOptions clientOptions = ClusterClientOptions.builder()
//                .topologyRefreshOptions(clusterTopologyRefreshOptions)
//                .build();
//
//        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
//                .clientResources(clientResources)
//                .clientOptions(clientOptions)
//                .commandTimeout(Duration.ofSeconds(3000L))
//                .readFrom(ReadFrom.REPLICA_PREFERRED)
//                .build();
//
//
//        return new LettuceConnectionFactory(
//                redisClusterConfiguration(), lettuceClientConfiguration);
//    }
//
//    @Bean
//    public RedisClusterConfiguration redisClusterConfiguration() {
//        RedisClusterConfiguration clusterConfiguration = new
//                RedisClusterConfiguration();
//        return clusterConfiguration.clusterNode("localhost", 6379);
//    }
//
//    @Bean
//    ClientResources clientResources() throws UnknownHostException {
//        var clientResourcesBuilder = DefaultClientResources.builder();
//        var configuredHost = "localhost";
//        var inetAddresses = Arrays.asList(InetAddress.getAllByName(configuredHost));
//        MappingSocketAddressResolver resolver = MappingSocketAddressResolver.create(
//                DnsResolvers.UNRESOLVED,
//                hostAndPort -> inetAddresses.stream()
//                        .anyMatch(i -> i.getHostAddress().equals(hostAndPort.getHostText())) ?
//                        HostAndPort.of(configuredHost, hostAndPort.getPort()) :
//                        hostAndPort
//        );
//        clientResourcesBuilder.socketAddressResolver(resolver);
//        return clientResourcesBuilder.build();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return redisTemplate;
//    }
//
//}
