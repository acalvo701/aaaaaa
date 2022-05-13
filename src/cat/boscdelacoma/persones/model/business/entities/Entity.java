
package cat.boscdelacoma.persones.model.business.entities;

import cat.boscdelacoma.persones.model.business.utilities.NumberUtils;


abstract public class Entity {
    private long ID;

    public Entity(){
        ID = NumberUtils.UNSAVED_VALUE;
    }
    
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        if(this.ID!=NumberUtils.UNSAVED_VALUE){
            throw new UnsupportedOperationException("id cannot be changed");
        }
        
        if(ID <= NumberUtils.ZERO){
            throw new IllegalArgumentException("id cannot be negative or zero");
        }
        this.ID = ID;
    }
}
