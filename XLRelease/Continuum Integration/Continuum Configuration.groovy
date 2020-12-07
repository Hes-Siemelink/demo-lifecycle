// Exported from:        http://xl-release:5516/#/templates/Folderc2bfcf472c7745c2ac47c9dedc46db4e-Release74c77caa455b4b8db978700967ac4b55/releasefile
// Release version:      9.8.0
// Date created:         Mon Dec 07 11:38:18 UTC 2020

xlr {
  template('Continuum Configuration') {
    folder('Continuum Integration')
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2020-12-07T11:23:43+0000')
    dueDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2020-12-07T12:23:43+0000')
    phases {
      phase('Configuration') {
        tasks {
          custom('Create Release Demo Team') {
            taskFailureHandlerEnabled true
            taskRecoverOp com.xebialabs.xlrelease.domain.recover.TaskRecoverOp.SKIP_TASK
            script {
              type 'continuum.CreateTeam'
              continuumServer 'Continuum'
              team_name 'Release Demo'
              description 'Demo Team for Release integration'
            }
          }
          custom('Configure Release GitHub') {
            taskFailureHandlerEnabled true
            taskRecoverOp com.xebialabs.xlrelease.domain.recover.TaskRecoverOp.SKIP_TASK
            script {
              type 'continuum.ConfigureGithub'
              continuumServer 'Continuum'
              githubServer 'GitHub xl-release'
            }
          }
          custom('Configure JIRA') {
            taskFailureHandlerEnabled true
            taskRecoverOp com.xebialabs.xlrelease.domain.recover.TaskRecoverOp.SKIP_TASK
            script {
              type 'continuum.ConfigureJira'
              continuumServer 'Continuum'
              jiraServer 'Jira Server'
              improve_types 'Story'
              maintain_types 'Bug', 'Task'
            }
          }
          custom('Configure Project') {
            taskFailureHandlerEnabled true
            taskRecoverOp com.xebialabs.xlrelease.domain.recover.TaskRecoverOp.SKIP_TASK
            script {
              type 'continuum.CreateProject'
              continuumServer 'Continuum'
              project_name 'Digital.ai Release Development'
              team 'Release Demo'
              description 'Source repository for Digital.ai Release'
            }
          }
        }
      }
      phase('Test') {
        color '#0079BC'
        tasks {
          gate('OK?') {
            
          }
        }
      }
    }
    
  }
}