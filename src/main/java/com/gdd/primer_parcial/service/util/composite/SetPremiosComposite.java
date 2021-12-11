package com.gdd.primer_parcial.service.util.composite;

import com.gdd.primer_parcial.service.composite.Premio;
import com.gdd.primer_parcial.service.composite.impl.RegaloHoja;
import com.gdd.primer_parcial.service.composite.impl.RegaloCompuesto;
import org.springframework.stereotype.Service;

@Service
public class SetPremiosComposite {


    public void setearArbolComposite(Premio premio, Premio premio1, Premio premio2, Premio premio3) {
        /*combo de regalos*/
        Premio premioCombo = new RegaloCompuesto("combo");
        Premio premio40 = new RegaloHoja("Comida Balanceada * 1 año");
        Premio premio41 = new RegaloHoja("peluqueria Mascota * 1año");
        premioCombo.add(premio40);
        premioCombo.add(premio41);


        /*nodo primerPremio*/
        Premio primerPremio = new RegaloHoja("iphone 13");
        premio1.add(primerPremio);
        premio1.add(premioCombo);


        /*nodo premio22*/
        Premio segundoPremio = new RegaloHoja("Mixer Philips");
        premio2.add(segundoPremio);
        premio2.add(premioCombo);

        /*nodo premio3*/
        premio3.add(premioCombo);


        premio.add(premio1);
        premio.add(premio2);
        premio.add(premio3);


    }
}
