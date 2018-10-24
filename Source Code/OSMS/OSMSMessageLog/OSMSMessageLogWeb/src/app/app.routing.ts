import { Routes, RouterModule, PreloadAllModules  } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { PagesComponent } from './pages/pages.component';
import { NotFoundComponent } from './pages/errors/not-found/not-found.component';
import { ErrorComponent } from './pages/errors/error/error.component';
import { MessageLogComponent } from './pages/message-log/message-log.component';
export const routes: Routes = [
    { 
        path: '', 
        component: PagesComponent, children: [
            {path: 'messageLog', component: MessageLogComponent, data: { breadcrumb: 'Message Log' }},
        ]
    },
    { path: 'landing', loadChildren: 'app/pages/landing/landing.module#LandingModule' },
    { path: 'login', loadChildren: 'app/pages/login/login.module#LoginModule' },
    { path: 'register', loadChildren: 'app/pages/register/register.module#RegisterModule' },
    { path: 'error', component: ErrorComponent, data: { breadcrumb: 'Error' } },
    { path: '**', component: NotFoundComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, {
   preloadingStrategy: PreloadAllModules,  // <- comment this line for activate lazy load
   // useHash: true
});