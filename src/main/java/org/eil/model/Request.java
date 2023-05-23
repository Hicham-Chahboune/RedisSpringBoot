package org.eil.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {
    String id;
}
