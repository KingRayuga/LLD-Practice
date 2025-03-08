package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupManager {
    private final List<Group> groupList;

    private GroupManager() {
        groupList = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final GroupManager INSTANCE = new GroupManager();
    }

    public static GroupManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void createGroup(Group group) {
        if (groupList.contains(group)) {
            throw new IllegalArgumentException("Group already exists.");
        }
        groupList.add(group);
    }

    public Group getGroup(UUID groupId) {
        for (Group group : groupList) {
            if (group.getId().equals(groupId)) {
                return group;
            }
        }
        throw new IllegalArgumentException("Group not found.");
    }

    public void updateGroup(UUID groupId, Group updatedGroup) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId().equals(groupId)) {
                groupList.set(i, updatedGroup);
                return;
            }
        }
        throw new IllegalArgumentException("Group not found.");
    }

    public void deleteGroup(UUID groupId) {
        groupList.removeIf(group -> group.getId().equals(groupId));
    }

    public List<Group> getAllGroups() {
        return new ArrayList<>(groupList);
    }
}