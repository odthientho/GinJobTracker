const quillContainer = new Quill('#body-create-job-content-form-editor', {
    theme: 'snow',
    modules: {
        toolbar: [
            ['bold', 'italic'],
            [{ 'list': 'bullet' }],
            ['link'],
            ['clean']
        ]
    }
});

