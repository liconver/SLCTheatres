import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotSiteComponent } from './forgot-site.component';

describe('ForgotSiteComponent', () => {
  let component: ForgotSiteComponent;
  let fixture: ComponentFixture<ForgotSiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForgotSiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForgotSiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
