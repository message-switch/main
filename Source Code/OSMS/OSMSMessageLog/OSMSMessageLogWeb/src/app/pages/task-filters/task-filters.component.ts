import { Component, OnInit, HostListener, ViewChild } from '@angular/core';
import { AppSettings } from '../../app.settings';
import { Settings } from '../../app.settings.model';
import { TaskFilter, TaskFiltersRequest, UserProfile } from './task-filters.model';
import { TaskFiltersService } from './task-filters.service';

@Component({
  selector: 'app-task-filters',
  templateUrl: './task-filters.component.html',
  styleUrls: ['./task-filters.component.scss']
})
export class TaskFiltersComponent implements OnInit {
    
  @ViewChild('sidenav') sidenav: any;
  public settings: Settings;
  public sidenavOpen:boolean;
  public taskFilters: Array<TaskFilter>;
  public currentTask:TaskFilter;

  constructor(public appSettings:AppSettings, private taskFilterService: TaskFiltersService) {
    this.settings = this.appSettings.settings; 
  }

  @HostListener('window:resize')
  public onWindowResize():void {
    (window.innerWidth <= 768) ? this.sidenavOpen = false : this.sidenavOpen = true;
  }

  ngOnInit(): void {
    this.sidenavOpen = true;
    this.getTaskFilters();
    if(window.innerWidth <= 768){
      this.sidenavOpen = false;
    }
  }

  getTaskFilters(): void {
    let request: TaskFiltersRequest = new TaskFiltersRequest();
    let userProfile: UserProfile = new UserProfile('jsmith', 'John', 'Smith', 'accountant', 'accounting');
    request.userProfile = userProfile;
    this.taskFilterService.getTaskFilters(request).subscribe(
      response => {
        console.log('getTaskFilters - response');
        console.log(response);
        this.taskFilters = response;
        if (this.taskFilters && this.taskFilters.length > 0) {
          this.currentTask = this.taskFilters[0];
        }
      }, error => {
        console.error(error);
      }
    )
  }

  showTask(task: TaskFilter): void {
    this.currentTask = task;
    if(window.innerWidth <= 768){
      this.sidenav.close();
    }
  }
}