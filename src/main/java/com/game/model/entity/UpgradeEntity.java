package com.game.model.entity;

import java.util.Objects;

public class UpgradeEntity {
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

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpgradeEntity that = (UpgradeEntity) o;
        return groupId == that.groupId &&
                resourceId == that.resourceId &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(groupDescription, that.groupDescription) &&
                Objects.equals(resourceName, that.resourceName) &&
                Objects.equals(resourceDescription, that.resourceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, groupDescription, resourceId, resourceName, resourceDescription);
    }

    @Override
    public String toString() {
        return "UpgradeEntity{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceDescription='" + resourceDescription + '\'' +
                '}';
    }
}
