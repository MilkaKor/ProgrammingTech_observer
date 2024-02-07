package BuilderComponents;

import Model.Mem;

public interface IBuilder {
    public void setImage();
    public void setText();
    public void setDesign();
    public void setColor();
    public Mem build();
}
