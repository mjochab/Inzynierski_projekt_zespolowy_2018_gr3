package patron.users.models;

import com.appscharles.libs.databaser.models.BaseModel;
import patron.users.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * The type Role.
 */
@Entity
@Table(name="role")
public class Role extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private RoleName roleName;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     */
    public Role(RoleName roleName) {
        this();
        this.roleName = roleName;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public RoleName getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
