package com.davidefalcone.springversion.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "cities")
@Data
public class City {

    @Id
    private String id;

    @Field(name = "Codice Regione", type = FieldType.Integer)
    private Integer codiceRegione;

    @Field(name = "Codice Città Metropolitana", type = FieldType.Integer)
    private Integer codiceCittaMetropolitana;

    @Field(name = "Codice Provincia (1)", type = FieldType.Integer)
    private Integer codiceProvincia;

    @Field(name = "Progressivo del Comune (2)", type = FieldType.Integer)
    private Integer progressivoDelComune;

    @Field(name = "Codice Comune formato alfanumerico", type = FieldType.Integer)
    private Integer codiceComuneFormatoAlfanumerico;

    @Field(name = "Denominazione in italiano", type = FieldType.Text)
    private String denominazioneInItaliano;

    @Field(name = "Denominazione in tedesco", type = FieldType.Text)
    private String denominazioneInTedesco;

    @Field(name = "Codice Ripartizione Geografica", type = FieldType.Integer)
    private Integer codiceRipartizioneGeografica;

    @Field(name = "Ripartizione geografica", type = FieldType.Text)
    private String ripartizioneGeografica;

    @Field(name = "Denominazione regione", type = FieldType.Text)
    private String denominazioneRegione;

    @Field(name = "Denominazione Città metropolitana", type = FieldType.Text)
    private String denominazioneCittaMetropolitana;

    @Field(name = "Denominazione provincia", type = FieldType.Text)
    private String denominazioneProvincia;

    @Field(name = "Flag Comune capoluogo di provincia", type = FieldType.Integer)
    private Integer flagComuneCapoluogoDiProvincia;

    @Field(name = "Sigla automobilistica", type = FieldType.Text)
    private String siglaAutomobilistica;

    @Field(name = "Codice Comune formato numerico", type = FieldType.Integer)
    private Integer codiceComuneFormatoNumerico;

    @Field(name = "Codice Comune numerico con 107 province (dal 2006 al 2009)", type = FieldType.Integer)
    private Integer codiceComuneCon107Province;

    @Field(name = "Codice Comune numerico con 103 province (dal 1995 al 2005)", type = FieldType.Integer)
    private Integer codiceComuneCon103Province;

    @Field(name = "Codice Catastale del comune", type = FieldType.Text)
    private String codiceCatastaleDelComune;

    @Field(name = "Popolazione legale 2011 (09/10/2011)", type = FieldType.Double)
    private Double popolazioneLegale2011;

    @Field(name = "Codice NUTS1 2010", type = FieldType.Text)
    private String codiceNUTS12010;

    @Field(name = "Codice NUTS2 2010 (3)", type = FieldType.Text)
    private String codiceNUTS22010;

    @Field(name = "Codice NUTS3 2010", type = FieldType.Text)
    private String codiceNUTS32010;

    @Field(name = "Codice NUTS1 2006", type = FieldType.Text)
    private String codiceNUTS12006;

    @Field(name = "Codice NUTS2 2006 (3)", type = FieldType.Text)
    private String codiceNUTS22006;

    @Field(name = "Codice NUTS3 2006", type = FieldType.Text)
    private String codiceNUTS32006;

}
