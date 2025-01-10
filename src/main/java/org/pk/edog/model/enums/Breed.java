package org.pk.edog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Breed {
    MIXED_BREAD("Mixed Bread"),
    LABRADOR_RETRIEVER("Labrador Retriever"),
    GERMAN_SHEPHERD("German Shepherd"),
    GOLDEN_RETRIEVER("Golden Retriever"),
    FRENCH_BULLDOG("French Bulldog"),
    BULLDOG("Bulldog"),
    POODLE("Poodle"),
    BEAGLE("Beagle"),
    ROTTWEILER("Rottweiler"),
    GERMAN_SHORTHAIRED_POINTER("German Shorthaired Pointer"),
    YORKSHIRE_TERRIER("Yorkshire Terrier"),
    DACHSHUND("Dachshund"),
    BOXER("Boxer"),
    PEMBROKE_WELSH_CORGI("Pembroke Welsh Corgi"),
    SIBERIAN_HUSKY("Siberian Husky"),
    GREAT_DANE("Great Dane"),
    DOBERMAN_PINSCHER("Doberman Pinscher"),
    AUSTRALIAN_SHEPHERD("Australian Shepherd"),
    SHIH_TZU("Shih Tzu"),
    MINIATURE_SCHNAUZER("Miniature Schnauzer"),
    CAVALIER_KING_CHARLES_SPANIEL("Cavalier King Charles Spaniel"),
    CHIHUAHUA("Chihuahua"),
    MALTESE("Maltese"),
    BOSTON_TERRIER("Boston Terrier"),
    SHIBA_INU("Shiba Inu"),
    BORDER_COLLIE("Border Collie"),
    BICHON_FRISE("Bichon Frise"),
    AKITA("Akita"),
    BELGIAN_MALINOIS("Belgian Malinois"),
    WEIMARANER("Weimaraner"),
    NEWFOUNDLAND("Newfoundland"),
    SAINT_BERNARD("Saint Bernard"),
    BASSET_HOUND("Basset Hound"),
    ALASKAN_MALAMUTE("Alaskan Malamute"),
    PUG("Pug"),
    IRISH_SETTER("Irish Setter"),
    WHIPPET("Whippet"),
    STAFFORDSHIRE_BULL_TERRIER("Staffordshire Bull Terrier"),
    BORZOI("Borzoi"),
    PAPILLON("Papillon");

    private final String displayName;
}
