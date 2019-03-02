CREATE TABLE [dbo].[Course](
	[courseId] [int] IDENTITY(1,1) NOT NULL,
	[courseName] [varchar](max) NOT NULL,
	[courseNumber] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[courseId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


CREATE TABLE [dbo].[Questions](
	[questionId] [int] IDENTITY(1,1) NOT NULL,
	[quizId] [int] NULL,
	[question] [nvarchar](max) NOT NULL,
	[actualAnswer] [nvarchar](max) NOT NULL,
	[totalChoices] [nvarchar](max) NULL,
	[totalPoints] [int] NOT NULL,
	[isMCQ] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[questionId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Questions]  WITH CHECK ADD FOREIGN KEY([quizId])
REFERENCES [dbo].[Quiz] ([quizId])
GO


CREATE TABLE [dbo].[Quiz](
	[quizId] [int] IDENTITY(1,1) NOT NULL,
	[courseId] [int] NULL,
	[isGraded] [bit] NOT NULL,
	[assignedTime] [int] NOT NULL,
	[quizInstruction] [nvarchar](max) NOT NULL,
	[quizScheduledDate] [date] NOT NULL,
	[isShuffled] [bit] NOT NULL,
	[quizTitle] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[quizId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD FOREIGN KEY([courseId])
REFERENCES [dbo].[Course] ([courseId])
GO



CREATE TABLE [dbo].[StudentResponse](
	[courseId] [int] NULL,
	[quizId] [int] NULL,
	[userId] [int] NULL,
	[questionId] [int] NULL,
	[answerSelected] [nvarchar](max) NOT NULL,
	[score] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[StudentResponse]  WITH CHECK ADD FOREIGN KEY([courseId])
REFERENCES [dbo].[Course] ([courseId])
GO

ALTER TABLE [dbo].[StudentResponse]  WITH CHECK ADD FOREIGN KEY([questionId])
REFERENCES [dbo].[Questions] ([questionId])
GO

ALTER TABLE [dbo].[StudentResponse]  WITH CHECK ADD FOREIGN KEY([quizId])
REFERENCES [dbo].[Quiz] ([quizId])
GO

ALTER TABLE [dbo].[StudentResponse]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[UserDetails] ([userId])
GO



CREATE TABLE [dbo].[UserCourseMApping](
	[userId] [int] NOT NULL,
	[courseId] [int] NOT NULL
) ON [PRIMARY]
GO



CREATE TABLE [dbo].[UserDetails](
	[firstname] [varchar](max) NOT NULL,
	[lastname] [varchar](max) NOT NULL,
	[phonenumber] [varchar](10) NOT NULL,
	[isStudent] [bit] NOT NULL,
	[email] [nvarchar](max) NOT NULL,
	[username] [nvarchar](max) NOT NULL,
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[password] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO