package com.gdd.primer_parcial.service.patrones.strategy;

import com.gdd.primer_parcial.model.Usuarios;
import com.gdd.primer_parcial.service.util.StrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ContextStrategy {

    /* @Autowired
     private MensajeStrategy mensajeStrategy;

     public String executeStrategy(Usuarios usuarios){
         return mensajeStrategy.enviarMensaje(usuarios);
     }*/
    private Map<StrategyName, MensajeStrategy> strategies;

    @Autowired
    public ContextStrategy(Set<MensajeStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public MensajeStrategy findStrategy(StrategyName strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<MensajeStrategy> strategySet) {
        strategies = new HashMap<StrategyName, MensajeStrategy>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getStrategyName(), strategy));
    }


}
