package BuilderComponents;

import Model.Mem;

public class Director {

    public Mem Construct(Builder builder){
        builder.setImage();
        builder.setDesign();
        builder.setColor();
        builder.setText();
        return builder.build();
    }

}
