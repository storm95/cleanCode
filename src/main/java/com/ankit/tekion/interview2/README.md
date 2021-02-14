Meeting Scheduler


- Create users


- Create meeting (users)
- Finding free (users, date)
- Meeting schedule (user, date range)
- Change status of the meeting for a user


UserID {
    String emailID;
}

ScheduledMeeting {
    
}

Meeting {
    String scheduledMeetingID;
    String meetingID;
    List<UserMeetingStatus> userMeetingStatus;
    Date date;
    Time startTime;
    Time endTime;
}

UserMeetingStatus {
    UserID userID;
    Status status;
}

enum Status {
    Accepted,
    Rejected, 
    MayBe,
    NotSeen
}

enum Cadence {
    none,
    weekly,
    monthly
}

MeetingController {
    List<Meeting> meetings;
    Map<String, User> emailIDToUser;
}

UserMeetings {
    User 
    List<Meeting> 
}

List<UserMeetings> getMeetingSchedules(List<UserID> userIDs, startTime, endTime) {
    U1, M1
    U2, M1, M2
}

createMeeting(List<UserID> userIDs, startDate, endDate, startTime, endTime, Cadence) {
    
}

9am - 10am
wed
27th Jan, 31st Jan
weekly

Meeting1 {
        scheduledMeetingID
        List<UserMeetingStatus> userMeetingStatus = [{U1, NotSeen}, {U2, NotSeen}];
        Date date; = 20jan2021
        Time startTime; 9
        Time endTime;   10
}


Meeting2 {
        scheduledMeetingID
        List<UserMeetingStatus> userMeetingStatus = [{U1, NotSeen}, {U2, NotSeen}];
        Date date; = 27jan2021
        Time startTime; 9
        Time endTime;   10
}