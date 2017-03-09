/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.parent;

/**
 *
 * @author Rice Pavel
 */
public abstract class PrimEntity {

    public abstract Long getId();

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();
        } else {
            return this.getClass().hashCode() + getId().intValue();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Class objCl = obj.getClass();
            Class thisCl = this.getClass();
            if (obj instanceof PrimEntity) {
                PrimEntity ent = (PrimEntity) obj;
                Long objId = ent.getId();
                Long thisId = this.getId();
                if (objId != null && thisId != null && objCl.equals(thisCl)
                        && objId.equals(thisId)) {
                    return true;
                }
            }
        }
        return false;
    }

}
