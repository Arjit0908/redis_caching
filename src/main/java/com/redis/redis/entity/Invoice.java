                                                                                                                                                                                                                        package com.redis.redis.entity;


                                                                                                                                                                                                                        import java.io.Serializable;

                                                                                                                                                                                                                        import jakarta.persistence.Entity;
                                                                                                                                                                                                                        import jakarta.persistence.GeneratedValue;
                                                                                                                                                                                                                        import jakarta.persistence.Id;
                                                                                                                                                                                                                        import lombok.AllArgsConstructor;
                                                                                                                                                                                                                        import lombok.Data;
                                                                                                                                                                                                                        import lombok.NoArgsConstructor;

                                                                                                                                                                                                                        @Data
                                                                                                                                                                                                                        @NoArgsConstructor
                                                                                                                                                                                                                        @AllArgsConstructor
                                                                                                                                                                                                                        @Entity
                                                                                                                                                                                                                        public class Invoice implements Serializable {
                                                                                                                                                                                                                          private static final long serialVersionUID = -4439114469417994311L;
                                                                                                                                                                                                                          @Id
                                                                                                                                                                                                                          private int invId;

                                                                                                                                                                                                                          private String invName;

                                                                                                                                                                                                                          private Double invAmount;
                                                                                                                                                                                                                        }





