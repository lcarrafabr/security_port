/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aecmtj
 */
public class ComboItem{
   private int id;
   private String label;

   /**
    *
    * @param id
    * @param label
    */
   public ComboItem(int id, String label)
   {
       this.id = id;
       this.label = label;
    }

    //getter and setter
    @Override
   public String toString()
   {
      return this.label;
    }

    /**
     *
     * @return
     */
    public Integer getId(){
    return this.id;
}

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     */
    public ComboItem(Integer id) {
        this.id = id;
}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComboItem)) {
            return false;
        }
        ComboItem other = (ComboItem) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }


}

