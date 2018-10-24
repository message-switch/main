import { Component, ViewChild, Input, OnInit } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { AppSettings } from '../../../app.settings';
import { Settings } from '../../../app.settings.model';
import { Record, TaskFilter } from '../task-filters.model';

@Component({
  selector: 'app-filter-detail',
  templateUrl: './filter-detail.component.html'
})
export class FilterDetailComponent implements OnInit {
    
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @Input() task: TaskFilter;
  public displayedColumns: Array<string>;
  public dataSource: any;
  public records: Array<Record>;
  public settings: Settings;

  constructor(public appSettings:AppSettings) {
    this.settings = this.appSettings.settings;  
  }

  ngOnInit(): void {
      if (this.task) {
        if (this.task.config && this.task.config.columns && this.task.config.columns.length > 0) {
            this.displayedColumns = this.task.config.columns;
        }
        if (this.task.results && this.task.results.length > 0) {
          this.records = new Array();
          this.task.results.forEach(result => {
              this.records.push(result.record)
          });
          this.dataSource = new MatTableDataSource<Record>(this.records);
        }
      }
  }
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  
}