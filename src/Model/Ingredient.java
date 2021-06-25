package Model;

import java.io.Serializable;

public class Ingredient implements Serializable
{
    private static final long serialVersionUID = 4390619385273939000L;

    private String ingredientName;

    public Ingredient(String name) { this.ingredientName = name; }
    public Ingredient()
    {}

    public String getName() { return ingredientName; }

    public void setName(String name) { this.ingredientName = name; }

    @Override
    public String toString()
    {
        return "Ingredient: " + ingredientName;
    }
}
