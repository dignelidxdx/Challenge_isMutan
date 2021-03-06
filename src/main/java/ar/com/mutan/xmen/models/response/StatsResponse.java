package ar.com.mutan.xmen.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonPropertyOrder({"count_mutant_dna", "count_human_dna","ratio" })
public class StatsResponse {
    @JsonProperty("count_mutant_dna")
    public long countMutantDNA;
    @JsonProperty("count_human_dna")
    public long countHumanDNA;
    @JsonProperty("ratio")
    public double ratio;

    @JsonProperty("total_count")
    public long totalCount;
}
