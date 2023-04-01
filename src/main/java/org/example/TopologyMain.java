package org.example;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

public class TopologyMain {
    public static void main(String[] args) throws AuthorizationException, InvalidTopologyException, AlreadyAliveException {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("simple-spout", new SimpleSpout());
        builder.setBolt("simple-bolt", new SimpleBolt()).shuffleGrouping("simple-spout");

        Config conf = new Config();
        conf.setDebug(true);

        StormSubmitter.submitTopology("simple", conf, builder.createTopology());

//        LocalCluster cluster = new LocalCluster();
//        try {
//            cluster.submitTopology("topology-main", conf, builder.createTopology());
//            Utils.sleep(30000);
//        } finally {
//            cluster.shutdown();
//        }

    }
}
