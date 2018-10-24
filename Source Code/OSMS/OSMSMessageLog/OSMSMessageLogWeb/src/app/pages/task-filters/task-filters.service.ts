import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TaskFiltersRequest, TaskFilter } from './task-filters.model';

@Injectable({
    providedIn: 'root'
})

export class TaskFiltersService {

    private URL: string = 'http://10.0.200.143:8080/CAMSREST/rest/CAMSDashboard/';

    constructor(public httpClient: HttpClient) {}

    getTaskFilters(taskRequest: TaskFiltersRequest) : Observable<Array<TaskFilter>> {
        const url = this.URL + 'defaultTaskList';
        return this.httpClient.post<Array<TaskFilter>>(url, taskRequest, httpOptions);
    }

}

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };