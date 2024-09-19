package model;

public enum PetType {

    Cat,
    Dog,
    Hamster,
    Camel,
    Horse,
    Donkey;

    public static PetType getType (int typeID){
        switch (typeID){
            case 1:
                return PetType.Cat;
            case 2:
                return PetType.Dog;
            case 3:
                return PetType.Hamster;
            case 4:
                return PetType.Camel;
            case 5:
                return PetType.Horse;
            case 6:
                return PetType.Donkey;
            default:
                return null;
        }
    }
}

