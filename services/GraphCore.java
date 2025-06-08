package services;

import entity.Barang;
import entity.Distributor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphCore {
    private Map<Distributor, Set<Barang>> graph;

    public GraphCore() {
        graph = new HashMap<>();
    }

    public void tambahEdge(Distributor distributor, Barang barang) {
        graph.putIfAbsent(distributor, new HashSet<>());
        graph.get(distributor).add(barang);
    }

    public void hapusEdge(Distributor distributor, Barang barang) {
        if (graph.containsKey(distributor)) {
            graph.get(distributor).remove(barang);
        }
    }

    public Set<Barang> getBarangByDistributor(Distributor distributor) {
        return graph.getOrDefault(distributor, new HashSet<>());
    }

    public Distributor cariDistributorDariBarang(Barang barang) {
        for (Map.Entry<Distributor, Set<Barang>> entry : graph.entrySet()) {
            if (entry.getValue().contains(barang)) {
                return entry.getKey();
            }
        }
        return null;
    }
}