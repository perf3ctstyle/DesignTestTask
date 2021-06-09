import java.util.Set;

public class DirectoryLogic {

    public static boolean entityWithSameNameExists(Entity entity, Set<? extends Entity> entitySet) {
        String nameOfEntityToCheck = entity.getName();

        for (Entity entityInSet : entitySet) {
            String nameOfEntityInSet = entityInSet.getName();

            if (nameOfEntityToCheck.equals(nameOfEntityInSet)) {
                return true;
            }
        }
        return false;
    }
}
