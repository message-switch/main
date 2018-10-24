export interface Parameters {
    assignee: string;
    candidateGroup: string;
}

export interface Config {
    filterName: string;
    filterType: string;
    description: string;
    parameters: Parameters;
    columns: string[];
}

export interface Record {
    createdDate: string;
    name: string;
    description: string;
    assignee: string;
    id: string;
    status: string;
}

export interface Result {
    record: Record;
    taskId?: any;
}

export interface TaskFilter {
    config: Config;
    results: Result[];
}

export class TaskFiltersRequest {
    userProfile: UserProfile;
    filterConfig?: any;
}

export class UserProfile {
    constructor(
        public userId: string,
        public firstName: string,
        public lastName: string,
        public role: string,
        public group: string) {}
}
