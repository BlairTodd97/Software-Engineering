package souschef.app.base.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import souschef.app.base.enums.CustomaryUnits;
import souschef.app.base.enums.MetricUnits;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    private @Id @GeneratedValue Long id;
    private String name;
    private CustomaryUnits custUnit;
    private MetricUnits metricUnit;

    //MAY NEED A UNITS CONVERTOR HELPER CLASS
    //this can change if this is a dto or not

    private void convertCustomaryToMetric(){};
    private void convertMetricToCustomary(){};

}
