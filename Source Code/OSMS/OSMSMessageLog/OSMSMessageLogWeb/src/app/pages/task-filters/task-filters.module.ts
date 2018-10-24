import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../../shared/shared.module';
import { HttpClientModule } from '@angular/common/http';

import { TaskFiltersComponent } from './task-filters.component';
import { FilterDetailComponent } from './filter-detail/filter-detail.component';

import { TaskFiltersService } from './task-filters.service';

export const routes = [
  { path: '', component: TaskFiltersComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule,
    HttpClientModule
  ],
  declarations: [
    TaskFiltersComponent,
    FilterDetailComponent
  ],
  providers: [
    TaskFiltersService
  ]
})
export class TaskFiltersModule { }