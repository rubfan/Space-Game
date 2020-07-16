package com.game.model.entity;

import java.util.Objects;

public class ShipEntity {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private int resourceId;
    private String resourceName;
    private String resourceDescription;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourseName) {
        this.resourceName = resourseName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipEntity shipEntity = (ShipEntity) o;
        return groupId == shipEntity.groupId &&
                resourceId == shipEntity.resourceId &&
                Objects.equals(groupName, shipEntity.groupName) &&
                Objects.equals(groupDescription, shipEntity.groupDescription) &&
                Objects.equals(resourceName, shipEntity.resourceName) &&
                Objects.equals(resourceDescription, shipEntity.resourceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, groupDescription, resourceId, resourceName, resourceDescription);
    }

    @Override
    public String toString() {
        return "ShipEntity{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceDescription='" + resourceDescription + '\'' +
                '}';
    }
}
