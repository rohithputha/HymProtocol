package org.hitro.binaryprotocol.services.orchestrators;

public interface Orchestrator<T,V> {
    public T orchestrate(V data);
}
