/**
 * Created by MKrasnyi on 05.05.2016.
 */
$('#mainModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var acc = button.data('whatever'); // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
    modal.find('.modal-title').text('Оцінка від клієнта з номером: ' + acc);
    modal.find('.modal-body #account').val(acc);
    modal.find('.modal-body #message-text').val('')
});

$('#mainModalhold').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);// Button that triggered the modal
    var acc = button.data('whatever'); // Extract info from data-* attributes
    var dt = button.data('tp'); // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('Оцінка від клієнта з номером: ' + acc)
    modal.find('.modal-body #account').val(acc);
    modal.find('.modal-body #datatype').val(dt);
    modal.find('.modal-body #message-text').val('');
});

$("#pattern1").on("change", function() {
    // alert( this.value ); // or $(this).val()
    $("#message-text").val($("#message-text").val()+this.value);
    //alert($("#message-text").css("color"));

});

$( "#addRate" ).submit(function( event ) {
    alert( "Handler for addRate.submit() called." );
    event.preventDefault();
});

function call() {
    var msg   = $('#formx').serialize();
    $.ajax({
        type: 'GET',
        url: './addRate',
        data: msg,
        success: function(data) {
            $('.results').html(data);
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
    $('#mainModal').modal('hide');
    document.getElementById(document.getElementById('account').value).style.display = 'none';


}
$(document).ready(function () {

    $('img.del_img').click(function (e) {
        var winWidth = $(window).width();
        var winHeight = $(document).height();
        $('#overlay').css({'width': winWidth + 'px', 'height': winHeight + 'px'}).show();

        if (!confirm('Видалити заявку?')) {
            window.location.reload();
        }

        var id = $(this).attr('id_db');

        $.post('delete_ticket.php', {id: id}, function () {
            $(e.target).closest("tr").hide();
            $('#overlay').hide();
        });
    });

});
