package org.eil.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

    @Builder
    @Data
    @NoArgsConstructor@AllArgsConstructor
    public class Response implements Serializable {
        private String id;
    }
